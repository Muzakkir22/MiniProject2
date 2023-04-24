import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { searchService } from './search.service';
import { HotelModel } from '../hotel.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{

  searchForm!:FormGroup

  searchModel! : HotelModel[];
  searchBarInfo = '';
  constructor(private fb: FormBuilder, private searchService: searchService, private router: Router) { }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      searchBar:['',[Validators.required]]
    })
  }


  search() {
    this.searchBarInfo = this.searchForm.get("searchBar")?.value;
    this.searchService.search(this.searchBarInfo).subscribe(data => {
      console.log(data)
      this.searchModel = data;
    })
  }

  getDetails(index: number){
    this.router.navigate(['search-detail', this.searchBarInfo, index]);
  }
}
