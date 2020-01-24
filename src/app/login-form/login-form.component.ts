import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ServletService } from '../servlet.service';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  constructor(private serObj: ServletService){}
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }

  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  submit() {
    if (this.form.valid)
    {
      this.submitEM.emit(this.form.value);
      this.serObj.isValid.next(true);
    }
  }
  @Input() error: string | null;

  @Output() submitEM = new EventEmitter();
}


