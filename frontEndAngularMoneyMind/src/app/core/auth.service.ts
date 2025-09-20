import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

interface LoginPayload {
  login: string;
  password: string;
}

interface TokenDTO {
  token: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  //END POINT QUE GERA O JWT PARA USAR NO LOGIN
  private apiUrl = 'http://localhost:8080/auth/login'; // ajuste se necessário

  //cria uma requisição HTTP para o endpoint de login (como se fosse um postman)
  constructor(private http: HttpClient) {}

  // faz a requisição post para o endpoint de login com o email e senha
  // e armazena o token JWT no localStorage se o login for bem-sucedido
   
  login(email: string, password: string): Observable<TokenDTO> {
    // Requisicao POST para a apiUrl passando o email e senha
    // retorna o TokenDTO (JWT)
    return this.http.post<TokenDTO>(this.apiUrl, { email, password }).pipe(
      tap(res => {
        localStorage.setItem('token', res.token);
      })
    );
  }

  logout() {
    if (typeof window !== 'undefined' && window.localStorage) {
      localStorage.removeItem('token');
    }
  }

  // Ajuste: só acessa localStorage no browser (SSR safe)
  getToken(): string | null {
    if (typeof window !== 'undefined' && window.localStorage) {
      return localStorage.getItem('token');
    }
    return null;
  }
}