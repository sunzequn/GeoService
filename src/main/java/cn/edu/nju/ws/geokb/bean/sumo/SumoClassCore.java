package cn.edu.nju.ws.geokb.bean.sumo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sloriac on 16/3/13.
 *
 * The Sumo class entity, containing core properties whose values are uris.
 */
public class SumoClassCore {

    private List<String> types = new ArrayList<>();
    private List<String> labels = new ArrayList<>();
    private List<String> superClasses = new ArrayList<>();
    private List<String> comments = new ArrayList<>();

    private List<String> axioms = new ArrayList<>();

    private List<String> equivalenceRelations = new ArrayList<>();
    private List<String> antiEquivalenceRelations = new ArrayList<>();

    private List<String> subsumingRelations = new ArrayList<>();
    private List<String> antiSubsumingRelations = new ArrayList<>();

    private List<String> instanceRelations = new ArrayList<>();

    private List<String> externalImages = new ArrayList<>();

    public SumoClassCore() {
    }

    public List<String> getTypes() {
        return types;
    }

    public void addType(String type) {
        this.types.add(type);
    }

    public List<String> getLabels() {
        return labels;
    }

    public void addLabel(String label) {
        this.labels.add(label);
    }

    public List<String> getSuperClasses() {
        return superClasses;
    }

    public void addSuperClass(String superClass) {
        this.superClasses.add(superClass);
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public List<String> getEquivalenceRelations() {
        return equivalenceRelations;
    }

    public void addEquivalenceRelation(String equivalenceRelation) {
        this.equivalenceRelations.add(equivalenceRelation);
    }

    public List<String> getAntiEquivalenceRelations() {
        return antiEquivalenceRelations;
    }

    public void addAntiEquivalenceRelation(String antiEquivalenceRelation) {
        this.antiEquivalenceRelations.add(antiEquivalenceRelation);
    }

    public List<String> getSubsumingRelations() {
        return subsumingRelations;
    }

    public void addSubsumingRelation(String subsumingRelation) {
        this.subsumingRelations.add(subsumingRelation);
    }

    public List<String> getAntiSubsumingRelations() {
        return antiSubsumingRelations;
    }

    public void addAntiSubsumingRelation(String antiSubsumingRelation) {
        this.antiSubsumingRelations.add(antiSubsumingRelation);
    }

    public List<String> getInstanceRelations() {
        return instanceRelations;
    }

    public void addInstanceRelation(String instanceRelation) {
        this.instanceRelations.add(instanceRelation);
    }

    public List<String> getExternalImages() {
        return externalImages;
    }

    public void addExternalImage(String externalImage) {
        this.externalImages.add(externalImage);
    }

    public List<String> getAxioms() {
        return axioms;
    }

    public void addAxiom(String axiom) {
        this.axioms.add(axiom);
    }

    @Override
    public String toString() {
        return "SumoClassCore{" +
                "types=" + types +
                ", labels=" + labels +
                ", superClasses=" + superClasses +
                ", comments=" + comments +
                ", axioms=" + axioms +
                ", equivalenceRelations=" + equivalenceRelations +
                ", antiEquivalenceRelations=" + antiEquivalenceRelations +
                ", subsumingRelations=" + subsumingRelations +
                ", antiSubsumingRelations=" + antiSubsumingRelations +
                ", instanceRelations=" + instanceRelations +
                ", externalImages=" + externalImages +
                '}';
    }
}
