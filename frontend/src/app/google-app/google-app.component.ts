import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { GoogleAppService } from './service/google-app.service';
import { LocationReqDTO, LocationResDTO } from './dto/LocationReqDTO';
import { GoogleMap, GoogleMapsModule } from '@angular/google-maps';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-google-app',
  standalone: true,
  imports: [
    GoogleMapsModule,
    ReactiveFormsModule
  ],
  templateUrl: './google-app.component.html',
  styleUrl: './google-app.component.css',
  providers: [
    GoogleAppService,
    GoogleMapsModule
  ],

})
export class GoogleAppComponent implements OnInit {
  onSubmit() {
 
    const req: LocationReqDTO = this.profileForm.value as unknown as LocationReqDTO;
    this.service.findAll(req)
      .subscribe(data => {
        this.addAllMarker(data);
        this.markerCenter();
        console.table(data);
      });

  }

  profileForm = this.formBuilder.group({
    longitude: ['', [Validators.required, Validators.max(180.0), Validators.min(-180.0)]],
    latitude: ['', [Validators.required, Validators.max(90.0), Validators.min(-90.0)]],
    radius: ['', [Validators.required, Validators.max(500.0), Validators.min(1.0)]],
  });


  @ViewChild(GoogleMap) googleMap!: GoogleMap;

  center!: google.maps.LatLngLiteral;
  lastCenter: google.maps.LatLngLiteral = {
     lat: 0.0 , lng: 0.0 };
  
  zoom = 14;
  markerOptions: google.maps.MarkerOptions = {
    draggable: false,
  };
  googleMapOptions: google.maps.MapOptions = {
    disableDefaultUI: true,
    zoomControl: true,
    mapTypeControl: false,
    streetViewControl: false,
    fullscreenControl: true
  }
  markerPositions: google.maps.LatLngLiteral[] = [];

  addAllMarker(response: LocationResDTO[]) {
    this.markerPositions = [];
    this.markerPositions.push(
      ...response.map(value => {
        const temp: google.maps.LatLngLiteral = {
          'lat': value.latitude,
          'lng': value.longitude
        };
        return temp;
      })
    );

  }



  constructor(private service: GoogleAppService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {

  }

  markerCenter() {
    
    try {
      let sumLat = 0.0;
    let sumLng = 0.0;
    this.markerPositions.forEach(val => {
      sumLat += val.lat;
      sumLng += val.lng;
    });
    const size = this.markerPositions.length * 1.0;
    if(size!=0) {
      this.center = { lat: sumLat / size, lng: sumLng / size };
      this.lastCenter = this.center ;
    } else {
      this.center = this.lastCenter;
    }
    } catch (error) {
      this.center = this.lastCenter ;
    }
  }

}
