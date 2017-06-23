package com.dlb.service;

import com.dlb.model.EndData;
import com.dlb.model.RequestForm;

public interface DataService {
   public String getDataToJson(RequestForm rform);
   public String getDataToJsonByid(RequestForm idform);
   public boolean storeJsonDate(EndData data);
}
