import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HotelModel } from '../hotel.model';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';

@Component({
  selector: 'app-search-detail',
  templateUrl: './search-detail.component.html',
  styleUrls: ['./search-detail.component.css']
})



export class SearchDetailComponent implements OnInit {

  Introduction = '';
  Information = '';
  Rating = '';
  Name = '';
  Type = '';
  NearestMRTStation = '';
  OfficialWebsite = '';
  OfficialEmail = '';
  ImageData = '';

  index!: number;
  searchBarInfo!: string;
  // Metadata!: metadata[];
  // ReviewData!: reviewData[];
  

  hotelModel!: HotelModel[];
  constructor(private http: HttpClient, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    console.log();
    this.activatedRoute.params.subscribe(data => {
      this.searchBarInfo = data['searchBarInfo'];
      this.index = data['index'];
    })

    this.getData(this.searchBarInfo, this.index);
  }

  getData(searchBarInfo: string, index: number) {
    const headers = new HttpHeaders()
    .set('content-type', 'applcation/json')
    .set('Access-Control-Allow-Origin', '*');

    var results = this.http.get('/getData/' + searchBarInfo, {headers: headers});

    results.subscribe( (data: any) => {
      console.log(data)
      this.hotelModel = data;
      // console.log(this.hotelModel[5].name);
      this.Name = this.hotelModel[index].name;
      this.ImageData = this.hotelModel[index].image;
      this.Introduction = this.hotelModel[index].description;
      this.Information = this.hotelModel[index].body
      .replaceAll("<p>", "")
      .replaceAll("</p>", "")
      .replaceAll("<br>", "")
      .replaceAll("</br>", "");
      this.Rating = this.hotelModel[index].rating.toString();
      this.Type = this.hotelModel[index].type;
      this.NearestMRTStation = this.hotelModel[index].nearestMRTStation;
      this.OfficialWebsite = this.hotelModel[index].officialWebsite;
      this.OfficialEmail = this.hotelModel[index].officialEmail;
      // this.Metadata = this.hotelModel[1].metadata;
      // console.log(this.Metadata);
      // this.ReviewData = this.hotelModel[1].reviews;
      // console.log(this.ReviewData);
      
    })
  }

}
