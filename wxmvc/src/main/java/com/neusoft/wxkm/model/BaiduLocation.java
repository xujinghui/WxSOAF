package com.neusoft.wxkm.model;

public class BaiduLocation {

	private Result result = null;

	private String status = null;

	public static class Result {
		private String business = null;
		private String cityCode = null;
		private String formatted_address = null;
		private AddressComponent addressComponent = null;

		public String getBusiness() {
			return business;
		}

		public void setBusiness(String business) {
			this.business = business;
		}

		public String getCityCode() {
			return cityCode;
		}

		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}

		public static class AddressComponent {
			private String city = null;
			private String district = null;
			private String province = null;
			private String street = null;
			private String street_number = null;

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getDistrict() {
				return district;
			}

			public void setDistrict(String district) {
				this.district = district;
			}

			public String getProvince() {
				return province;
			}

			public void setProvince(String province) {
				this.province = province;
			}

			public String getStreet() {
				return street;
			}

			public void setStreet(String street) {
				this.street = street;
			}

			public String getStreet_number() {
				return street_number;
			}

			public void setStreet_number(String street_number) {
				this.street_number = street_number;
			}

		}

		public String getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}

		public AddressComponent getAddressComponent() {
			return addressComponent;
		}

		public void setAddressComponent(AddressComponent addressComponent) {
			this.addressComponent = addressComponent;
		}

		private Location location = null;

		public static class Location {
			private String lng = null;
			private String lat = null;

			public String getLng() {
				return lng;
			}

			public void setLng(String lng) {
				this.lng = lng;
			}

			public String getLat() {
				return lat;
			}

			public void setLat(String lat) {
				this.lat = lat;
			}

		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
