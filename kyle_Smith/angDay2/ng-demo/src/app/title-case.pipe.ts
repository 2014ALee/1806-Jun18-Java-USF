import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleCase'
})
export class TitleCasePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (!value) { return null; }

    const words: string[] = value.split(' ');

    for (let i = 0; i < words.length; i++) {
      const word = words[i];

      if (i > 0 && this.isPreposition(word)) {
        words[i] = word.toLowerCase();
      } else {
        words[i] = this.toTitleCase(word);
      }
    }

    return words.join(' ');
  }

  private isPreposition(word: String): boolean {
    const prepositions = [
      'of', 'the', 'for', 'over', 'to', 'in', 'by', 'with'
    ];

    return prepositions.includes(word.toLowerCase());
  }

  private toTitleCase(word: string): string {
    return word = (word.substring(0, 1)).toUpperCase() + (word.substring(1)).toLowerCase();
  }
}
