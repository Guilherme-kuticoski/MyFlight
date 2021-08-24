package pucrs.myflight.modelo;

import jdk.jshell.Diag;

public class Geo {
	private double latitude;
	private double longitude;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double distancia(Geo geo){
		Geo obj = new Geo(getLatitude(), getLongitude());
		return distancia(obj, geo);
	}

	public static double distancia(Geo geo1, Geo geo2) {
		double deltaLat = Math.toRadians(geo1.getLatitude() - geo2.getLatitude());
		double deltaLon = Math.toRadians(geo1.getLongitude() - geo2.getLongitude());

		double lat1 = Math.toRadians(geo1.getLatitude());
		double lat2 = Math.toRadians(geo2.getLatitude());

		double hav = Math.sqrt(
			Math.pow(Math.sin(deltaLat / 2), 2) +
			Math.pow(Math.sin(deltaLon / 2), 2) *
			Math.cos(lat1) * Math.cos(lat2)
		);

		return 12742 * Math.asin(hav);
	}
}
