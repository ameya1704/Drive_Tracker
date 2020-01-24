import { Component, OnInit } from '@angular/core';
import { ServletService } from '../servlet.service';

@Component({
  selector: 'app-view-drive',
  templateUrl: './view-drive.component.html',
  styleUrls: ['./view-drive.component.css']
})
export class ViewDriveComponent implements OnInit {

  data:any[];
  constructor(private Ser:ServletService) { }

  ngOnInit() {
    this.relod()
  }     
  relod(){
    this.data= null;
    this.Ser.viewdata().subscribe((e:any)=>{this.data=e});
  }

  deleteData(cid)
  {
    alert("Successfully Deleted");
    return this.Ser.deleteData(cid).subscribe(e=>{
      this.relod();
    });
    
  }

}
