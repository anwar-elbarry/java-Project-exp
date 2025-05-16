export interface User {
    id: number;
    username: string;
    email: string;
    password: string;
}

export interface UserResponse {
    message: string;
    user: User;
}

