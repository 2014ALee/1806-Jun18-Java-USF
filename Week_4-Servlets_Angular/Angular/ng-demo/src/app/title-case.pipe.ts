import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleCase'
})
export class TitleCasePipe implements PipeTransform {

  transform(value: string, args?: any): any {
<<<<<<< HEAD
    if (!value) {return null;}

    let words: string[] = value.split(' ');

    for (let i = 0; i < words.length; i++) {
      let word = words[i];

      if (i > 0 && this.isPreposition(word)) {
=======
    if(!value) return null;

    let words: string[] = value.split(' ');

    for(let i = 0; i < words.length; i++) {
      let word = words[i];
      
      if(i > 0 && this.isPreposition(word)) {
>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0
        words[i] = word.toLowerCase();
      } else {
        words[i] = this.toTitleCase(word);
      }
    }
<<<<<<< HEAD
=======

>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0
    return words.join(' ');
  }

  private isPreposition(word: string): boolean {
    let prepositions = [
<<<<<<< HEAD
      'of', 'the', 'an', 'a', 'for', 'to', 'to', 'in', 'with'
=======
      'of', 'the', 'for', 'over', 'by', 'to' , 'in', 'with'
>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0
    ];

    return prepositions.includes(word.toLowerCase());
  }

  private toTitleCase(word: string): string {
<<<<<<< HEAD
    return word = word.substr(0, 1).toUpperCase() + word.substr(1).toLowerCase();
  }

=======
    return (word.substr(0, 1).toUpperCase() + word.substr(1).toLowerCase());
  }
>>>>>>> 5717e2f2f24bdb0c3e20692b4502664434d443e0
}
