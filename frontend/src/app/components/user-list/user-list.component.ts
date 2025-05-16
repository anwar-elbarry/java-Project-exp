import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user/user.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-user-list',
  imports: [NgFor],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css',
  standalone: true
})
export class UserListComponent implements OnInit {
   users : User[] = [];
   constructor(private userService: UserService) {}

   ngOnInit(){
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    })
   }
}
