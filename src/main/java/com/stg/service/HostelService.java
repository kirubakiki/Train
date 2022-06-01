package com.stg.service;

import java.util.List;

import com.stg.model.Hostel;

public interface HostelService {

	public abstract Hostel createHost(Hostel hostel);

	public abstract List<Hostel> getHostels();

	public abstract Hostel readHostByCode(int hostCode);

	public abstract Hostel readHostByName(String hostName);

	public abstract Hostel updateHost(Hostel hostel);

	public abstract int deleteHostByCode(int hostCode);

	//public abstract String deleteHostByName(String hostName);

}
