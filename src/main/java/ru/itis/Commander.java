package ru.itis;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.IParameterSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Parameters(separators = "=")
public class Commander {
    @Parameter(names = "--file_path", required = true)
    static String filePath;
    @Parameter(names = "--id", listConverter = IdListConverter.class, splitter = SemiColonSplitter.class)
    static List<Long> ids;

    public class IdListConverter implements IStringConverter<List<Long>> {
        @Override
        public List<Long> convert(String urls) {
            String[] idsAsString = urls.split(",");
            List<Long> urlList = new ArrayList<>();
            for (String idAsString : idsAsString)
                urlList.add(new Long(idAsString));
            return urlList;
        }
    }

    public static class SemiColonSplitter implements IParameterSplitter {
        public List<String> split(String value) {
            return Arrays.asList(value.split(";"));
        }
    }

}
