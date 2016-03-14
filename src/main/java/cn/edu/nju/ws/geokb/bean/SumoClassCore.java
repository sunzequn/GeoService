package cn.edu.nju.ws.geokb.bean;

import java.util.List;

/**
 * Created by Sloriac on 16/3/13.
 */
public class SumoClassCore {

    private List<String> types;
    private List<String> labels;
    private List<String> superClasses;
    private List<String> comments;

    private List<String> equivalenceRelations;
    private List<String> antiEquivalenceRelations;

    private List<String> subsumingRelations;
    private List<String> antiSubsumingRelations;

    private List<String> instanceRelations;

    private List<String> externalImages;

    public SumoClassCore() {
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getSuperClasses() {
        return superClasses;
    }

    public void setSuperClasses(List<String> superClasses) {
        this.superClasses = superClasses;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getEquivalenceRelations() {
        return equivalenceRelations;
    }

    public void setEquivalenceRelations(List<String> equivalenceRelations) {
        this.equivalenceRelations = equivalenceRelations;
    }

    public List<String> getAntiEquivalenceRelations() {
        return antiEquivalenceRelations;
    }

    public void setAntiEquivalenceRelations(List<String> antiEquivalenceRelations) {
        this.antiEquivalenceRelations = antiEquivalenceRelations;
    }

    public List<String> getSubsumingRelations() {
        return subsumingRelations;
    }

    public void setSubsumingRelations(List<String> subsumingRelations) {
        this.subsumingRelations = subsumingRelations;
    }

    public List<String> getAntiSubsumingRelations() {
        return antiSubsumingRelations;
    }

    public void setAntiSubsumingRelations(List<String> antiSubsumingRelations) {
        this.antiSubsumingRelations = antiSubsumingRelations;
    }

    public List<String> getInstanceRelations() {
        return instanceRelations;
    }

    public void setInstanceRelations(List<String> instanceRelations) {
        this.instanceRelations = instanceRelations;
    }

    public List<String> getExternalImages() {
        return externalImages;
    }

    public void setExternalImages(List<String> externalImages) {
        this.externalImages = externalImages;
    }

    @Override
    public String toString() {
        return "SumoClassCore{" +
                "types=" + types +
                ", labels=" + labels +
                ", superClasses=" + superClasses +
                ", comments=" + comments +
                ", equivalenceRelations=" + equivalenceRelations +
                ", antiEquivalenceRelations=" + antiEquivalenceRelations +
                ", subsumingRelations=" + subsumingRelations +
                ", antiSubsumingRelations=" + antiSubsumingRelations +
                ", instanceRelations=" + instanceRelations +
                ", externalImages=" + externalImages +
                '}';
    }
}
