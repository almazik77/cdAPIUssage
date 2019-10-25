package ru.itis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.itis.models.ContestInfo;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataFromAPI {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    public void close() throws IOException {
        httpClient.close();
    }

    private String urlBinding(List<ParameterWithValue> parameters, String start) {
        StringBuilder result = new StringBuilder(new String(start));

        for (ParameterWithValue parameter : parameters) {
            result.append(parameter.toString());
            result.append("&");
        }
        result.deleteCharAt(result.lastIndexOf("&"));
        return result.toString();
    }
    public ContestInfo sendGet(Long contestId) {
        List<ParameterWithValue> parameters = new ArrayList<>();
        parameters.add(new ParameterWithValue("contestId", contestId.toString()));
        parameters.add(new ParameterWithValue("showUnofficial", "true"));
        Collections.sort(parameters);
        String url = urlBinding(parameters, "http://codeforces.com/api/contest.standings?");
        return sendGet0(url);
    }

    private ContestInfo sendGet0(String url) {
        System.out.println(url);
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return mapper.readValue(result, ContestInfo.class);
            }
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ContestInfo sendGet(Long contestId, String apiKey, String secret) {
        List<ParameterWithValue> parameters = new ArrayList<>();
        parameters.add(new ParameterWithValue("contestId", contestId.toString()));
        parameters.add(new ParameterWithValue("showUnofficial", "true"));
        parameters.add(new ParameterWithValue("apiKey", apiKey));
        parameters.add(new ParameterWithValue("time", Long.toString(System.currentTimeMillis() / 1000)));
        Collections.sort(parameters);
        String stringForHash = urlBinding(parameters, "987654/contest.standings?").concat("#".concat(secret));
        String hash = DigestUtils.sha512Hex(stringForHash);
        parameters.add(new ParameterWithValue("apiSig", "987654".concat(hash)));
        String url = urlBinding(parameters, "http://codeforces.com/api/contest.standings?");
        return sendGet0(url);
    }

    private static class ParameterWithValue implements Comparable<ParameterWithValue> {
        String param;
        String value;

        public ParameterWithValue(String param, String value) {
            this.param = param;
            this.value = value;
        }

        @Override
        public String toString() {
            return param + '=' + value;
        }

        @Override
        public int compareTo(ParameterWithValue parameterWithValue) {
            if (param.equals(parameterWithValue.param)) {
                return value.compareTo(parameterWithValue.value);
            }
            return param.compareTo(parameterWithValue.param);
        }
    }
}
