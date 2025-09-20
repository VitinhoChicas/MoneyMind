import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

export interface UsuarioDTO {
  idUsuario?: number;
  nomeUsuario: string;
  emailUsuario: string;
  senhaUsuario: string;
  dataNascimento: string; // yyyy-MM-dd (input type date)
}

@Injectable({ providedIn: 'root' })
export class UserService {
  private apiUrl = 'http://localhost:8080/usuario'; // ajuste para compatibilidade com backend

  constructor(private http: HttpClient, private auth: AuthService) {}

  register(usuario: UsuarioDTO): Observable<any> {
    // Cadastro é público, não precisa de token
    return this.http.post(this.apiUrl, usuario, { observe: 'response' });
  }

  update(id: number, usuario: UsuarioDTO): Observable<any> {
    const token = this.auth.getToken();
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.put(`${this.apiUrl}/${id}`, usuario, { headers });
  }

  delete(id: number): Observable<any> {
    const token = this.auth.getToken();
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.delete(`${this.apiUrl}/${id}`, { headers });
  }
}