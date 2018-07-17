import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleCase'
})
export class TitleCasePipe implements PipeTransform {

  transform(value: string, args?: any): any {
    if (!value) {
      return null;
    }

    let words = value.split(' ');

    for(let i = 0; i < words.length; i++){
      let word = words[i];

      if (i > 0 && this.isPreposition(word)){
        words[i] = word.toLowerCase();
      } else {
        words[i] = this.toTitleCase(word);
      }
    }

    return words.join(' ');
  }

  private isPreposition(word: string): boolean{
    // Obviously not a complete list
    let prepositions = ['of', 'the', 'a', 'an', 'for', 'over', 'to', 'in', 'with'];

    return prepositions.includes(word.toLowerCase());
  }

  private toTitleCase(word: string): string {
    return (word.substr(0, 1).toUpperCase() + word.substr(1).toLowerCase());
  }
}
