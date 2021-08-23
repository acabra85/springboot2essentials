package com.acabra.webapp.model;

import java.util.List;

public enum JobPosition {
    HOUSE_KEEPER(0), CONCIERGE(1), FRONT_DESK_CLERK(2), SECURITY_GUARD(3);

    private static final List<JobPosition> positions = List.of(HOUSE_KEEPER, CONCIERGE, FRONT_DESK_CLERK, SECURITY_GUARD);


    private final int id;

    JobPosition(int id) {
        this.id = id;
    }

    public static JobPosition getPositionById(int id) {
        if(id<0 || id > 3) throw new IllegalArgumentException("Only 4 Positions are available, received:"+ id);
        return positions.get(id);
    }
}
