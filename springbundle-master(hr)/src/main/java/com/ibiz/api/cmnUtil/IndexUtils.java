package com.ibiz.api.cmnUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class IndexUtils {
    /**
     * iBiz 테이블에서 사용될 ID를 채번한다.
     *
     * @author GyeongYong Bang
     * @param idSize 채번하고자하는 ID 사이즈
     * @param prevIdSeq 최근 채번된 ID의 시퀀스
     * @return 년도와 시퀀스가 연속화되어 생성된 ID
     */
    public static String generateId(int idSize, String prevId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        Date currentTime = new Date();
        String sequencePrefix = simpleDateFormat.format(currentTime);
        int nextSequence;

        if (sequencePrefix.equals(prevId.substring(0, 4))) {
            nextSequence = Integer.parseInt(prevId.substring(4)) + 1;
        } else {
            nextSequence = 1;
        }

        String Sequenceformat = "%0" + Integer.toString(idSize - sequencePrefix.length()) +"d";

        return sequencePrefix + String.format(Sequenceformat, nextSequence);
    }

    /**
     * 프로젝트에서 사용될 ID를 채번한다.
     *
     * @author Bombsu Seong
     * @param idSize 채번하고자하는 ID 사이즈
     * @param prevIdSeq 최근 채번된 ID의 시퀀스
     * @return 년도와 시퀀스가 연속화되어 생성된 ID
     */
    public static String generatePrjtId(int prevIdSeq) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy", Locale.KOREA);
        //IBIZ 프로젝트 ID는 50001 ~ 99999 번 때문에 이전 시퀀스 값은 - 50000을 가산함
        int tempPrevIdSeq = 0;

        if(prevIdSeq > 50000){
            tempPrevIdSeq = prevIdSeq - 50000;
        }

        Date currentTime = new Date();
        String sequencePrefix = "P"+simpleDateFormat.format(currentTime);

        String Sequenceformat = "%0" + Integer.toString(8 - sequencePrefix.length()) +"d";

        //+50001로 시퀀스 계산
        int nextIdSeq = tempPrevIdSeq + 50001;

        return sequencePrefix + String.format(Sequenceformat, nextIdSeq);
    }
}
