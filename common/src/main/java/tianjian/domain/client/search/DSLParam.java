package tianjian.domain.client.search;

import java.util.ArrayList;
import java.util.List;

public class DSLParam {

    private List<SearchParam> searchParams;

    private List<SortParam> sortParams;

    private RowData rowData;

    public DSLParam() {
        this.searchParams = new ArrayList<SearchParam>();
        this.sortParams = new ArrayList<SortParam>();
        this.rowData = new RowData();
    }

    public DSLParam setSearchParam(String fileName, String fileValue) {
        SearchParam searchParam = new SearchParam();
        searchParam.setFileName(fileName);
        searchParam.setFileValue(fileValue);
        searchParams.add(searchParam);
        return this;
    }

    public DSLParam setSortParam(String fileName, SortEnum sortEnum) {
        SortParam sortParam = new SortParam();
        sortParam.setFileName(fileName);
        sortParam.setSortEnum(sortEnum);
        sortParams.add(sortParam);
        return this;
    }

    public DSLParam setRowData(String from, String end) {
        rowData.setFrom(from);
        rowData.setTo(end);
        return this;
    }

    public List<SearchParam> getSearchParam() {
        return searchParams;
    }

    public List<SortParam> getSortParam() {
        return sortParams;
    }

    public class SearchParam{
        private String fileName;
        private String fileValue;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileValue() {
            return fileValue;
        }

        public void setFileValue(String fileValue) {
            this.fileValue = fileValue;
        }
    }

    public class SortParam {
        private String fileName;
        private SortEnum sortEnum;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public SortEnum getSortEnum() {
            return sortEnum;
        }

        public void setSortEnum(SortEnum sortEnum) {
            this.sortEnum = sortEnum;
        }
    }

    public class RowData {
        private String from;
        private String to;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }
}
