package za.co.crosstek.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

@Entity
public class Attachment extends CoreEntity  {

    @Basic(fetch = LAZY)
    @Lob
    private byte[] file;

    @NotNull
    private String fileName;

    private Integer fileSize;;

    public Boolean getPdf() {
        Boolean isPdf = Boolean.FALSE;

        if (!StringUtils.isEmpty(fileName) && (fileName.endsWith("pdf") || (fileName.endsWith("PDF")))) {
            isPdf = Boolean.TRUE;
        }
        return isPdf;
    }



    public void setFile(byte[] file, String filename) {
        this.file = file;
        setFileName(filename);

        if (file != null) {
            setFileSize(file.length);
        }
    }

    public byte[] getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFile(byte[] file) {
        this.file = file;

        if (file != null) {
            setFileSize(file.length);
        }
    }

    public void setFileName(String fileName) {
        
        if (!StringUtils.isEmpty(fileName)) {
            fileName = fileName.replaceAll("[^a-zA-Z0-9.\\-\\\\(\\\\)\\s]", "_");
        }
        
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return this.fileName;
    }

}
