import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface UsuarioInfo {
  idUsuario: number;
  nomeUsuario: string;
  emailUsuario: string;
  dataNascimento: string;
}

@Injectable({ providedIn: 'root' })
export class UserInfoService {
  // Ajustado para usar o endpoint /usuario/me
  private apiUrl = 'http://localhost:8080/usuario/me';

  constructor(private http: HttpClient) {}

  getMe(): Observable<UsuarioInfo> {
    return this.http.get<UsuarioInfo>(this.apiUrl);
  }
}