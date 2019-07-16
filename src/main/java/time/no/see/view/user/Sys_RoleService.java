package time.no.see.view.user;

import time.no.see.model.beans.role.Sys_Role;

public interface Sys_RoleService {


	Sys_Role findSys_RoleByUsername(String username);

}
