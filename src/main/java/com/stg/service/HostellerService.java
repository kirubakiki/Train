package com.stg.service;

import java.util.List;

import com.stg.model.Hostel;
import com.stg.model.Hosteller;

public interface HostellerService {

	public abstract Hosteller createHostlr(Hosteller hosteller);

	 public abstract List<Hosteller> getHostellers(); 

	public abstract Hosteller readHostlrByNum(int hostelrNum);

	public abstract Hosteller readHostlrByName(String hostelrName);

	public abstract Hosteller updateHostlr(Hosteller hosteller);

	public abstract int deleteHostlrByCode(int hostelrNum);

	public abstract String deleteHostlrByName(String hostelrName);

}
