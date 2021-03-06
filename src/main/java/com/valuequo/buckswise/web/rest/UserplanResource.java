package com.valuequo.buckswise.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.valuequo.buckswise.service.UserplanService;
import com.valuequo.buckswise.web.rest.errors.BadRequestAlertException;
import com.valuequo.buckswise.web.rest.util.HeaderUtil;
import com.valuequo.buckswise.service.dto.UserplanDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import com.valuequo.buckswise.domain.Userplan;

/**
 * REST controller for managing Userplan.
 */
@RestController
@RequestMapping("/api")
public class UserplanResource {

    private final Logger log = LoggerFactory.getLogger(UserplanResource.class);

    private static final String ENTITY_NAME = "userplan";

    private final UserplanService userplanService;

    public UserplanResource(UserplanService userplanService) {
        this.userplanService = userplanService;
    }

    /**
     * POST  /userplans : Create a new userplan.
     *
     * @param userplanDTO the userplanDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userplanDTO, or with status 400 (Bad Request) if the userplan has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/userplans")
    @Timed
    public ResponseEntity<UserplanDTO> createUserplan(@RequestBody UserplanDTO userplanDTO) throws URISyntaxException {
        log.debug("REST request to save Userplan : {}", userplanDTO);
        if (userplanDTO.getId() != null) {
            throw new BadRequestAlertException("A new userplan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserplanDTO result = userplanService.save(userplanDTO);
        return ResponseEntity.created(new URI("/api/userplans/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /userplans : Updates an existing userplan.
     *
     * @param userplanDTO the userplanDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userplanDTO,
     * or with status 400 (Bad Request) if the userplanDTO is not valid,
     * or with status 500 (Internal Server Error) if the userplanDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/userplans")
    @Timed
    public ResponseEntity<UserplanDTO> updateUserplan(@RequestBody UserplanDTO userplanDTO) throws URISyntaxException {
        log.debug("REST request to update Userplan : {}", userplanDTO);
        if (userplanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserplanDTO result = userplanService.save(userplanDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userplanDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /userplans : get all the userplans.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of userplans in body
     */
    @GetMapping("/userplans")
    @Timed
    public List<UserplanDTO> getAllUserplans() {
        log.debug("REST request to get all Userplans");
        return userplanService.findAll();
    }

    // @GetMapping("/get/{uid}")
    // @Timed
    // public ResponseEntity<Userplan> getUserplan(@PathVariable Long uid) {
    //     log.debug("REST request to get Userplan : {}", uid);
    //     List<Userplan> userplan = userplanService.getByUser(uid);
    //     return ResponseUtil.wrapOrNotFound(userplan);
    // }

    @GetMapping("/getuser/{uid}")
    @Timed
    public List<Userplan> getuserId(@PathVariable Long uid) {
    	return userplanService.getUser(uid);
    }

    @GetMapping("/getuserplan/{uid}")
    @Timed
    public Long getUserPlan(@PathVariable Long uid) {
        return userplanService.getUserPlan(uid);
    }
}
