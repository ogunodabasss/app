FROM node:18 

RUN mkdir /usr/src/app 
 
WORKDIR /usr/src/app

RUN npm install -g @angular/cli@17.0.0
RUN npm install -g @angular/google-maps@17.0.0
RUN npm install -g rxjs@7.8.0
RUN npm install -g typescript@5.2.2

COPY . . 

