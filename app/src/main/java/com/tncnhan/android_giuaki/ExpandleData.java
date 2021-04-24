package com.tncnhan.android_giuaki;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandleData {
    public static HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> getData(){
        HashMap<PhieuChamBai, ArrayList<ThongTinChamBai>> expandleListDetail = new HashMap<>();
        ArrayList<ThongTinChamBai> list1 = new ArrayList<>();
        ArrayList<ThongTinChamBai> list2 = new ArrayList<>();

        MonHoc mh1 = new MonHoc("GT1", "Giai tích 1", 2000, "");
        ThongTinChamBai ptt1 = new ThongTinChamBai(mh1, 5);
        MonHoc mh2 = new MonHoc("GT2", "Giai tích 2", 3000, "");
        ThongTinChamBai ptt2 = new ThongTinChamBai(mh2, 7);
        MonHoc mh3 = new MonHoc("DS1", "Đại số 1", 4000, "");
        ThongTinChamBai ptt3 = new ThongTinChamBai(mh3, 4);
        MonHoc mh4 = new MonHoc("DS2", "Đại số 2", 5000, "");
        ThongTinChamBai ptt4 = new ThongTinChamBai(mh4, 4);

        list1.add(0, ptt1);
        list1.add(1,ptt2);

        list2.add(0, ptt3);
        list2.add(1,ptt4);

        PhieuChamBai pc1 = new PhieuChamBai(1, "24/04/2021", list1);
        PhieuChamBai pc2 = new PhieuChamBai(2, "23/04/2021", list2);
        PhieuChamBai pc3 = new PhieuChamBai(3, "22/04/2021", list1);
        PhieuChamBai pc4 = new PhieuChamBai(4, "21/04/2021", list2);
        expandleListDetail.put(pc1, list1);
        expandleListDetail.put(pc2, list2);
        expandleListDetail.put(pc3, list1);
        expandleListDetail.put(pc4, list2);
        return expandleListDetail;
    }
}
