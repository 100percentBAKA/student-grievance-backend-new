package com.rnsit.studentgrievance.entity.grievance;

public enum GrievanceStatus {
      RAISED,                             // student raised grievance
      PENDING_ACTION,           // asking for details ( comments )
      IN_PROGRESS,                  // grievance being worked on ( faculty answered on a grievance )
      WITH_DRAWN,                 // user withdrawn grievance
      RESOLVED                        // grievance resolved ( user accepted grievance )
}