import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { HotelModel } from "./search.model";

@Injectable({providedIn: 'root'})

export class searchService{

    constructor(private http: HttpClient) {}

    search(searchBarInfo: string) {
        const headers = new HttpHeaders()
        .set('content-type', 'application/json')
        .set('Access-Control-Allow-Origin', '*');

        var url = '/getData/' + searchBarInfo;

        return this.http.get<HotelModel[]>(url, {headers: headers});
    }
}