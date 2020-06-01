package com.Jackson.Binder.Config;

import com.Jackson.Binder.Enum.Raça;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public abstract class RaçaDescerialize extends StdSerializer<Raça> {
    public RaçaDescerialize(Class<Raça> t) {
        super (t);
    }
}
