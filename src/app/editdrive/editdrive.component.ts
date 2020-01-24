import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl,Validators } from '@angular/forms';
import {ServletService} from '../servlet.service';
import { ActivatedRoute } from '@angular/router';

@Component
({
  selector: 'app-edit-drive',
  templateUrl: './editdrive.component.html',
  styleUrls: ['./editdrive.component.css']
})
export class EditDriveComponent implements OnInit
{
  viewDrives:any[];
  singleDrive:any;
  id:number;
  editform:FormGroup;

  constructor(private _ser:ServletService,private _ar:ActivatedRoute) { }
  
  ngOnInit()
  {
    this.id = this._ar.snapshot.params['id'];
    console.log(this.id);
    this._ser.viewdata().subscribe((e:any)=>{this.viewDrives=e;
    
    for(let i=0; i<this.viewDrives.length; i++)
    {
      if(this.viewDrives[i].id==this.id)
      {
        this.singleDrive=this.viewDrives[i];
      }
    }
    console.log(this.singleDrive);
 });

//for edit purpose

      this.editform=new FormGroup
      ({
      id:new FormControl('',[Validators.required]),
      companyname:new FormControl('',[Validators.required]),
      resource:new FormControl('',[Validators.required]),
      exp:new FormControl('',[Validators.required]),
      ctc:new FormControl('',[Validators.required]),
      joining:new FormControl('',[Validators.required]),
      bond:new FormControl('',[Validators.required]),
      position:new FormControl('',[Validators.required]),
      education:new FormControl('',[Validators.required]),
      followup: new FormControl('',[Validators.required]),    
  });
}
update() 
{
  this._ser.editData(this.editform.value).subscribe();
  console.log(this.editform.value);
  alert("Drive Updated Successfully");
}
}