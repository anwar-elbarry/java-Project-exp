import { Component } from '@angular/core';
import { book } from '../../models/book';
import { BookService } from '../../services/book/book.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent {
   books : book[] = [];
   constructor(private bookService : BookService){}

   ngOnInit(){
    this.bookService.getBooks().subscribe((data) => {
      this.books = data;
    })
   }
}
