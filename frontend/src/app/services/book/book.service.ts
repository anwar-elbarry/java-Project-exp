import { Injectable } from '@angular/core';
import { book } from '../../models/book';
import { of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor() { }
    getBooks(){
      const books : book[] = [
        {title : "anwiii",description : "awjknsk k fks"},
        {title : "errrer",description : "dgdg  f fffss"},
        {title : "rqgdfg",description : "ajdy çegfv ksirhf"},
      ];
      return of(books)
    }
}
