package com.tickmanage.constant;

public class PathGeneric {

    public static final String PATH_ID = "/{id}";
    public static final String PATH_API_TICKETS = "/api/tickets";
    public static final String PATH_CREATE_TICKET = "/create";
    public static final String PATH_UPDATE_TICKET = "/update" + PATH_ID;
    public static final String PATH_DELETE_TICKET = "/delete" + PATH_ID;
    public static final String PATH_GET_TICKET_BY_ID = PATH_ID;
    public static final String PATH_GET_ALL_TICKETS = "/all";
    public static final String PATH_GET_TICKETS_BY_USER = "/user/{user}";
    public static final String PATH_CLOSE_TICKET = "/{id}/close";


    public static final String PATH_API_GITHUB = "/api/github";
    public static final String PATH_SEARCH_USERS = "/users";

}
