import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'joining'
})
export class JoiningPipe implements PipeTransform {

  transform(value: any, joining: string): any {
    if(value==0)
    {
      return "No training and Direct joining";
    }
    else
    {
      return "1-3 months internship and then joining";
    }
  }

}
