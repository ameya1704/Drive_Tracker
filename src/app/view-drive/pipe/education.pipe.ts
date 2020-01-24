import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'education'
})
export class EducationPipe implements PipeTransform {

  transform(value:number, education: any): any {
    if(value==0)
    {
      return "B.E."
    }
    else if(value==1)
    {
      return "BCA/MCA"
    }
    else
    {
      return "Other"
    }
  }

}
