package Chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). 
 * There can be multiple employees, but only one TL or PM. 
 * An incoming telephone call must be allocated to a fresher who is free. 
 * If a fresher can’t handle the call, he or she must escalate the call to technical lead. 
 * If the TL is not free or not able to handle it, then the call should be escalated to PM. 
 * Design the classes and data structures for this problem. Implement a method getCallHandler().
 *
 */
public class Q7_2 {

}

class Employee {
	int rank;//FRESHER : 0, TL: 1, PM : 2
	boolean free;
	
	Employee(int r) {
		rank = r;
	}
}

class Fresher extends Employee {
	public Fresher() {
		super(0);
	}
}

class TL extends Employee {
	public TL() {
		super(1);
	}
}

class PM extends Employee {
	public PM() {
		super(2);
	}
}

class Call {
	int rank = 0; //Minimum rank of employee who can handle this call
}

class CallHandler {
	static final int numFreshers = 10;
	static final int levels = 3;
	ArrayList<Employee>[] employeeLevels = new ArrayList[levels];
	
	Queue<Call>[] callQueue = new LinkedList[levels];
	
	Employee getCallhandler(Call call) {
		for(int l=call.rank; l<=levels; l++) {
			ArrayList<Employee> emp = employeeLevels[l];
			for(Employee e: emp) {
				if(e.free) {
					return e;
				}
			}
		}
		return null; 
	}
	
	void routeCall(Call call) {
		Employee emp = getCallhandler(call);
		if(emp != null) {
			//Call should be received by this employee
		}else {
			//Place the call in the queue
			callQueue[call.rank].add(call);
		}
	}
}
