package com.saucedemo.models;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter

public class ModelCustomer {

    private String f_name;
    private String l_name;
    private String p_code;

    public ModelCustomer(DataTable customer) {
        List<Map<String, String>> rows = customer.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            this.f_name = columns.get("f_name");
            this.l_name = columns.get("l_name");
            this.p_code = columns.get("p_code");
        }
    }

}
