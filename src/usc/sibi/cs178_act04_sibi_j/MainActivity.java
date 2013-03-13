package usc.sibi.cs178_act04_sibi_j;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;


public class MainActivity extends Activity {

	 static final LatLng TC = new LatLng(10.35410, 123.91145);
	  static final LatLng MAIN = new LatLng(10.30046, 123.88822);
	  static final LatLng SM = new LatLng(10.31234, 123.92002);
	  private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println(GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()));
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 final Marker tc = map.addMarker(new MarkerOptions().position(TC)
			        .title("USC-TC"));
		 final Marker main = map.addMarker(new MarkerOptions().position(MAIN)
			        .title("USC Main"));
		 final Marker smcebu = map.addMarker(new MarkerOptions().position(SM).title("SM City Cebu"));
			
		 map.animateCamera(CameraUpdateFactory.newLatLngZoom(TC, map.getMaxZoomLevel()));

		 
		 map.setOnMarkerClickListener(new OnMarkerClickListener(){
			    	
			    	AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
			    	
				@Override
					public boolean onMarkerClick(Marker mk) {
						// TODO Auto-generated method stub
						alert.setTitle("Travel Mojo");
						
						if(mk.equals(tc)){
							alert.setMessage("Heading to USC Main! Are you sure you want to continue?")
							.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									map.animateCamera(CameraUpdateFactory.newLatLngZoom(MAIN, map.getMaxZoomLevel()));
								}
							}).setNegativeButton("NOPE.", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {}
							});
							
						} else if(mk.equals(main)){
							alert.setMessage("Heading to SM City Cebu! Are you sure you want to continue?")
							.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									map.animateCamera(CameraUpdateFactory.newLatLngZoom(SM, map.getMaxZoomLevel()));
								}
							}).setNegativeButton("NOPE.", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {}
							});
							
						} else if(mk.equals(smcebu)){
							alert.setMessage("Heading to USC-TC! Are you sure you want to continue?")
							.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									map.animateCamera(CameraUpdateFactory.newLatLngZoom(TC, map.getMaxZoomLevel()));
								}
							}).setNegativeButton("NOPE.", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {}
							});
							
						}
						
						AlertDialog alertDialog = alert.create();
						alertDialog.show();
					
						return false;
					}
			    	
			    	
			    });

			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
