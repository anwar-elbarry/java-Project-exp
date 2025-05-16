import { Injectable } from '@angular/core';
import { User } from '../../models/user';
import { of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

    getUsers(){
      const users : User[] = [
      { id: 1, username: 'Anouar', email: 'anouar@example.com',password : 'password123' },
      { id: 2, username: 'Sara', email: 'sara@example.com' ,password : 'password123'},
      { id: 3, username: 'Youssef', email: 'youssef@example.com', password : 'password123' }
      ];
      return of(users);
    }
}
