package mu.micro.java.framework.core.client.selector;

import mu.micro.java.framework.core.context.MicroContext;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SelectOptions {
    private List<Filter> filters;
    private Strategy strategy;
    private MicroContext context;

    public void setFilters(List<Filter> filters) {
        if (this.filters == null) {
            this.filters = new ArrayList<>();
        }

        this.filters.addAll(filters);
    }
}
