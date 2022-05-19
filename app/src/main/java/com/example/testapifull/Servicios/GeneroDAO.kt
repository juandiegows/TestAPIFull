package com.example.testapifull.Servicios

import com.example.testapifull.model.Genero
import com.example.testapifull.model.User

class GeneroDAO : CRUD("https://628650cb96bccbf32d732618.mockapi.io/api/v1/Genero",
    Genero().javaClass.name
) {
}