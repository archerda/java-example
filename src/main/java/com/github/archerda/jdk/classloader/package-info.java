/**
 * Classloader:
 * 1. Bootstrap Classloader; -> jre/lib/*.jar
 * 2. Extension Classloader; -> jre/lib/ext/*.jar
 * 3. System Classloader;
 *
 * 每个ClassLoader加载Class的过程是：
 * 1.检测此Class是否载入过（即在cache中是否有此Class），如果有到8,如果没有到2
 * 2.如果parent classloader不存在（没有parent，那parent一定是bootstrap classloader了），到4
 * 3.请求parent classloader载入，如果成功到8，不成功到5
 * 4.请求jvm从bootstrap classloader中载入，如果成功到8
 * 5.寻找Class文件（从与此classloader相关的类路径中寻找）。如果找不到则到7.
 * 6.从文件中载入Class，到8.
 * 7.抛出ClassNotFoundException.
 * 8.返回Class.
 *
 * Created by archerda on 06/08/2017.
 */
package com.github.archerda.jdk.classloader;