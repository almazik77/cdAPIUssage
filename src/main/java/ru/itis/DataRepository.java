package ru.itis;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.itis.models.ContestInfo;
import ru.itis.models.Member;
import ru.itis.models.Party;
import ru.itis.models.RanklistRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.Commander.filePath;

public class DataRepository {
    Workbook workbook;
    String filePath;
    Map<String, Integer> handlesInFile;
    Sheet sheet;

    public DataRepository(String filePath) {
        try {
            this.filePath = filePath;
            handlesInFile = new HashMap<>();
            File inputFile = new File(filePath);
            workbook = WorkbookFactory.create(inputFile);
            if (workbook.getSheet("Main") == null) {
                workbook.createSheet("Main");
                Sheet sheet = workbook.getSheet("Main");
                sheet.createRow(0).createCell(0).setCellValue("handles");
            }
            sheet = workbook.getSheet("Main");
            for (int i = 1; sheet.getRow(i) != null; i++) {
                String handle = sheet.getRow(i).getCell(0).getStringCellValue();
                handlesInFile.put(handle, i);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void save(ContestInfo contestInfo) {
        try {
            Integer currentColumn = 1;

            for (; sheet.getRow(0).getCell(currentColumn) != null; currentColumn++) ;

            sheet.getRow(0).createCell(currentColumn); // столбец для тек. соревнования
            sheet.getRow(0).createCell(currentColumn + 1); // столбец для тек. соревнования Дорешка

            sheet.getRow(0).getCell(currentColumn).setCellValue(contestInfo.getResult().getContest().getId());
            sheet.getRow(0).getCell(currentColumn + 1).setCellValue(contestInfo.getResult().getContest().getId() + "UpSolving");

            List<RanklistRow> ranklistRows = contestInfo.getResult().getRows();

            for (RanklistRow ranklistRow : ranklistRows) {
                Party party = ranklistRow.getParty();
                int i = 0;
                if (party.getGhost()) continue;
                if (party.getParticipantType().equals("OUT_OF_COMPETITION") || party.getParticipantType().equals("PRACTICE"))
                    i++;
                List<String> handleList = new ArrayList<>();
                if (ranklistRow.getParty() != null && ranklistRow.getParty().getMembers() != null && ranklistRow.getParty().getMembers().size() > 0) {
                    for (Member member : ranklistRow.getParty().getMembers())
                        handleList.add(member.getHandle());
                } else {
                    if (ranklistRow.getParty() != null) {
                        handleList.add(ranklistRow.getParty().getTeamName());
                    }
                }

                for (String handle : handleList) {
                    Integer row;
                    if (handlesInFile.containsKey(handle)) {
                        row = handlesInFile.get(handle);
                    } else {
                        row = handlesInFile.size() + 1;
                        handlesInFile.put(handle, row);
                        sheet.createRow(row);
                        sheet.getRow(row).createCell(0);
                        sheet.getRow(row).getCell(0).setCellValue(handle);
                    }
                    if (sheet.getRow(row).getCell(currentColumn) == null) {
                        sheet.getRow(row).createCell(currentColumn);
                        sheet.getRow(row).createCell(currentColumn + 1);
                    }
                    sheet.getRow(row).getCell(currentColumn + i).setCellValue(ranklistRow.getPoints());
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void close() {
        try (FileOutputStream fileOut = new FileOutputStream(filePath + ".new", false)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}