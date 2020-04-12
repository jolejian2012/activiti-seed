package com.liwnily.activiti.seed.activiti;

import org.activiti.engine.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @author winily
 * @date 2020/4/12
 */
@SpringBootTest
public class ProcessDeploymentTest {
    @Autowired
    private RepositoryService repositoryService;


    @Test
    void deployByString() {
        String bpmn = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:camunda=\"http://camunda.org/schema/1.0/bpmn\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\" id=\"m1577635100724\" name=\"\" targetNamespace=\"http://www.activiti.org/testm1577635100724\">\n" +
                "  <process id=\"demoByString\" name=\"DemoByString\" processType=\"None\" isClosed=\"false\" isExecutable=\"true\">\n" +
                "    <extensionElements>\n" +
                "      <camunda:properties>\n" +
                "        <camunda:property name=\"a\" value=\"1\" />\n" +
                "      </camunda:properties>\n" +
                "    </extensionElements>\n" +
                "    <startEvent id=\"_2\" name=\"start\">\n" +
                "      <outgoing>SequenceFlow_06ecyje</outgoing>\n" +
                "    </startEvent>\n" +
                "    <task id=\"Task_0xns2h7\" name=\"task1\">\n" +
                "      <incoming>SequenceFlow_06ecyje</incoming>\n" +
                "      <outgoing>SequenceFlow_0gfpxr6</outgoing>\n" +
                "    </task>\n" +
                "    <sequenceFlow id=\"SequenceFlow_06ecyje\" sourceRef=\"_2\" targetRef=\"Task_0xns2h7\" />\n" +
                "    <task id=\"Task_1rmrosm\" name=\"task2\">\n" +
                "      <incoming>SequenceFlow_0gfpxr6</incoming>\n" +
                "      <outgoing>SequenceFlow_11xfslc</outgoing>\n" +
                "    </task>\n" +
                "    <sequenceFlow id=\"SequenceFlow_0gfpxr6\" sourceRef=\"Task_0xns2h7\" targetRef=\"Task_1rmrosm\" />\n" +
                "    <endEvent id=\"EndEvent_0nt66s0\">\n" +
                "      <incoming>SequenceFlow_11xfslc</incoming>\n" +
                "    </endEvent>\n" +
                "    <sequenceFlow id=\"SequenceFlow_11xfslc\" sourceRef=\"Task_1rmrosm\" targetRef=\"EndEvent_0nt66s0\" />\n" +
                "  </process>\n" +
                "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_leave\">\n" +
                "    <bpmndi:BPMNPlane id=\"BPMNPlane_leave\" bpmnElement=\"demo1\">\n" +
                "      <bpmndi:BPMNShape id=\"BPMNShape__2\" bpmnElement=\"_2\">\n" +
                "        <omgdc:Bounds x=\"144\" y=\"368\" width=\"32\" height=\"32\" />\n" +
                "        <bpmndi:BPMNLabel>\n" +
                "          <omgdc:Bounds x=\"149\" y=\"400\" width=\"23\" height=\"14\" />\n" +
                "        </bpmndi:BPMNLabel>\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNShape id=\"Task_0xns2h7_di\" bpmnElement=\"Task_0xns2h7\">\n" +
                "        <omgdc:Bounds x=\"230\" y=\"344\" width=\"100\" height=\"80\" />\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge id=\"SequenceFlow_06ecyje_di\" bpmnElement=\"SequenceFlow_06ecyje\">\n" +
                "        <di:waypoint x=\"176\" y=\"384\" />\n" +
                "        <di:waypoint x=\"230\" y=\"384\" />\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "      <bpmndi:BPMNShape id=\"Task_1rmrosm_di\" bpmnElement=\"Task_1rmrosm\">\n" +
                "        <omgdc:Bounds x=\"390\" y=\"344\" width=\"100\" height=\"80\" />\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge id=\"SequenceFlow_0gfpxr6_di\" bpmnElement=\"SequenceFlow_0gfpxr6\">\n" +
                "        <di:waypoint x=\"330\" y=\"384\" />\n" +
                "        <di:waypoint x=\"390\" y=\"384\" />\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "      <bpmndi:BPMNShape id=\"EndEvent_0nt66s0_di\" bpmnElement=\"EndEvent_0nt66s0\">\n" +
                "        <omgdc:Bounds x=\"552\" y=\"366\" width=\"36\" height=\"36\" />\n" +
                "      </bpmndi:BPMNShape>\n" +
                "      <bpmndi:BPMNEdge id=\"SequenceFlow_11xfslc_di\" bpmnElement=\"SequenceFlow_11xfslc\">\n" +
                "        <di:waypoint x=\"490\" y=\"384\" />\n" +
                "        <di:waypoint x=\"552\" y=\"384\" />\n" +
                "      </bpmndi:BPMNEdge>\n" +
                "    </bpmndi:BPMNPlane>\n" +
                "  </bpmndi:BPMNDiagram>\n" +
                "</definitions>\n";
        this.repositoryService.createDeployment()
                .name("demoByString")
                .addString("demoByString", bpmn)
                .category("demo")
                .key("demoByString")
                .deploy();
    }

    @Test
    void deployByClasspath() {
        this.repositoryService.createDeployment()
                .addClasspathResource("bpmn/demo1.bpmn")
                .name("demoByClasspath")
                .key("demoByClasspath")
                .category("demo")
                .deploy();
    }

    @Test
    void deployByZip() {
        InputStream in = this.getClass().getClassLoader().getSystemResourceAsStream("bpmn/demo1.zip");
        ZipInputStream zipInputStream = new ZipInputStream(in);
        this.repositoryService.createDeployment()
                .name("deployByZip")
                .key("deployByZip")
                .category("demo")
                .addZipInputStream(zipInputStream)
                .deploy();
    }
}
