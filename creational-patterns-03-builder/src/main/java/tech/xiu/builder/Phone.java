package tech.xiu.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    protected String cpu;

    protected String memory;

    protected String storage;

    protected String camera;

}
