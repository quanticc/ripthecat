package top.quantic.ripthecat.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Releases {

    private Map<String, Object> sort = new LinkedHashMap<>();
    private List<Release> results = new ArrayList<>();
    private long total;

    public Map<String, Object> getSort() {
        return sort;
    }

    public void setSort(Map<String, Object> sort) {
        this.sort = sort;
    }

    public List<Release> getResults() {
        return results;
    }

    public void setResults(List<Release> results) {
        this.results = results;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
