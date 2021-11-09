import { DomSanitizer } from '@angular/platform-browser';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'marcarTexto'
})
export class MarcarTextoPipe implements PipeTransform {
constructor(private domSanitizer:DomSanitizer){}
  transform(value: any, args?: any): any {
    if (!args) {return value;}
        var expressao = new RegExp(args, 'gi'); 
        return this.domSanitizer.bypassSecurityTrustHtml(value.replace(expressao, '<span style="color: red; background-color:yellow"><b>$&</b></span>'));
  }

}