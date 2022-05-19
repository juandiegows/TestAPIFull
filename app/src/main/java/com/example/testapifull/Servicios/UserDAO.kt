package com.example.testapifull.Servicios

import com.example.testapifull.model.User

class UserDAO : CRUD(
    "https://628650cb96bccbf32d732618.mockapi.io/api/v1/Usuario",
    User().javaClass.name
) {
}