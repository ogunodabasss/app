import { Injectable } from '@angular/core';
import { ConfigService } from '../../config/config.service';
import { HttpErrorResponse, HttpParams } from '@angular/common/http';
import { LocationReqDTO, LocationResDTO } from '../dto/LocationReqDTO';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { BASE_URL } from '../../../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class GoogleAppService {

  constructor(private configService: ConfigService) { }

  findAll(reqDto: LocationReqDTO): Observable<LocationResDTO[]> {
    return this.configService.http.get<LocationResDTO[]>(`${BASE_URL}`, {
      params: {
        'longitude': reqDto.longitude,
        'latitude': reqDto.latitude,
        'radius': reqDto.radius
      }
    })
      .pipe(
        retry(0),
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
