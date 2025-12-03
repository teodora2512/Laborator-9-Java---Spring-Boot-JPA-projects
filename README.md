# Laborator 9 - Sistem Management Mașini

## Problema
Să se creeze un sistem de management al mașinilor care să permită operații CRUD (Create, Read, Update, Delete) pe o bază de date MySQL. Pentru fiecare mașină se memorează: numărul de înmatriculare, marca, anul fabricației, culoarea și numărul de kilometri.

## Soluție Implementată în 2 Moduri

### 1. **cars -JPA Repository/**
Implementare folosind **JPA Basic** cu EntityManager - abordarea tradițională.

### 2. **cars -SPRING DATA JPA Repository/**
Implementare folosind **Spring Data JPA** - abordarea modernă automatizată.

## Funcționalități Comune (ambele implementări)
- Adăugare mașină în baza de date
- Ștergere mașină după număr înmatriculare  
- Căutare mașină după număr înmatriculare
- Listare tuturor mașinilor
- Numărare mașini după marcă
- Numărare mașini cu sub 100.000 km
- Extragere mașini mai noi de 5 ani

## Tehnologii
- Java 17
- Spring Boot 3.5.8
- MySQL
- Maven

## Configurare
1. Clonează repository-ul
2. Setează MySQL cu utilizatorul `root` și parola `Scotti22`
3. Rulează cu `mvn spring-boot:run`

## Autor
Teodora Otelariu
