import { Routes } from '@angular/router';
import { UserListComponent } from './components/user-list/user-list.component';
import { BookListComponent } from './components/book-list/book-list.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'users',
        pathMatch: 'full'
    },
    {
        path: 'users',
        component: UserListComponent
    },
    {
        path : 'books',
        component : BookListComponent
    }
];
